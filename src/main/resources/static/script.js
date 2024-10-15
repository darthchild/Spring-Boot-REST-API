const API_URL = "http://localhost:8080/employees";
const content = document.getElementById("content");
const homeBtn = document.getElementById("homeBtn");
const getAllBtn = document.getElementById("getAllBtn");
const addMemberBtn = document.getElementById("addMemberBtn");
const searchBtn = document.getElementById("searchBtn");
const searchInput = document.getElementById("searchInput");

function setActiveButton(button) {
  document
    .querySelectorAll("button")
    .forEach((btn) => btn.classList.remove("active"));
  button.classList.add("active");
}

homeBtn.addEventListener("click", () => {
  setActiveButton(homeBtn);
  content.innerHTML = `
        <div class="welcome-message">
            <h1>Welcome to the Employee Dashboard</h1>
            <p>Use the navigation bar to interact with the app.</p>
        </div>
    `;
});

// DISPLAY ALL MEMBERS
getAllBtn.addEventListener("click", () => {
  setActiveButton(getAllBtn);
  fetch(`${API_URL}/all`, { mode: 'no-cors' })
    .then((response) => response.json())
    .then((data) => {
      let tableHtml = `
                <table>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Active</th>
                        <th>Actions</th>
                    </tr>
            `;
      data.forEach((member) => {
        tableHtml += `
                    <tr>
                        <td>${member.id}</td>
                        <td>${member.name}</td>
                        <td>${member.email}</td>
                        <td>${member.isActive}</td>
                        <td>
                            <button onclick="editMember(${member.id})">Edit</button>
                            <button onclick="deleteMember(${member.id})">Delete</button>
                        </td>
                    </tr>
                `;
      });
      tableHtml += "</table>";
      content.innerHTML = tableHtml;
    })
    .catch((error) => {
      console.error("Error:", error);
      content.innerHTML = "<p>Error fetching members. Please try again.</p>";
    });
});


addMemberBtn.addEventListener("click", () => {
  setActiveButton(addMemberBtn);
  content.innerHTML = `
        <div class="form-container">
            <h2>Add New Member</h2>
            <input type="text" id="idInput" placeholder="ID">
            <input type="text" id="nameInput" placeholder="Name">
            <input type="email" id="emailInput" placeholder="Email">
            <label for="isActive">Is Active:</label>
            <select id="isActive">
                <option value="true">True</option>
                <option value="false">False</option>
            </select>
            <button onclick="addNewMember()">Submit</button>
        </div>
    `;
});

// ADD MEMBER 
function addNewMember() {
  const id = document.getElementById("idInput").value;
  const name = document.getElementById("nameInput").value;
  const email = document.getElementById("emailInput").value;
  const isActive = document.getElementById("isActive").value === "true";

  fetch(API_URL, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ id, name, email, isActive }),
  })
    .then((response) => response.json())
    .then((data) => {
      alert("Member added successfully!");
      getAllBtn.click();
    })
    .catch((error) => {
      console.error("Error:", error);
      alert("Error adding member. Please try again.");
    });
}

// UPDATE MEMBER 
function editMember(id) {
  fetch(`${API_URL}/${id}`)
    .then((response) => response.json())
    .then((member) => {
      content.innerHTML = `
                <div class="form-container">
                    <h2>Edit Member</h2>
                    <input type="text" id="editNameInput" value="${member.name}">
                    <input type="email" id="editEmailInput" value="${member.email}">
                    <button onclick="updateMember(${id})">Update</button>
                </div>
            `;
    })
    .catch((error) => {
      console.error("Error:", error);
      alert("Error fetching member details. Please try again.");
    });
}

function updateMember(id) {
  const name = document.getElementById("editNameInput").value;
  const email = document.getElementById("editEmailInput").value;
  fetch(`${API_URL}/${id}`, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ name, email }),
  })
    .then((response) => response.json())
    .then((data) => {
      alert("Member updated successfully!");
      getAllBtn.click();
    })
    .catch((error) => {
      console.error("Error:", error);
      alert("Error updating member. Please try again.");
    });
}

// DELETE MEMBER
function deleteMember(id) {
  if (confirm("Are you sure you want to delete this member?")) {
    fetch(`${API_URL}/${id}`, {
      method: "DELETE",
    })
      .then((response) => response.json())
      .then((data) => {
        if (data) {
          alert("Member deleted successfully!");
          getAllBtn.click();
        } else {
          alert("Error deleting member. Please try again.");
        }
      })
      .catch((error) => {
        console.error("Error:", error);
        alert("Error deleting member. Please try again.");
      });
  }
}

// SEARCH FUNCTIONALITY (GET METHOD)

searchBtn.addEventListener('click', () => {
    const searchId = searchInput.value;
    if (!searchId) {
        alert('Please enter a member ID');
        return;
    }

    fetch(`${API_URL}/${searchId}`)
        .then(response => {
          console.log(response.data);
            if (!response.ok) {
                throw new Error('Member not found');
            }
            return response.json();
        })
        .then(member => {
            let tableHtml = `
                <table>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Active</th>
                        <th>Actions</th>
                    </tr>
                    <tr>
                        <td>${member.id}</td>
                        <td>${member.name}</td>
                        <td>${member.isActive}</td>
                        <td>${member.email}</td>
                        <td>
                            <button onclick="editMember(${member.id})">Edit</button>
                            <button onclick="deleteMember(${member.id})">Delete</button>
                        </td>
                    </tr>
                </table>
            `;
            content.innerHTML = tableHtml;
        })
        .catch(error => {
            console.error('Error:', error);
            content.innerHTML = '<p>Member not found. Please try a different ID.</p>';
        });
});
// Initialize the app
homeBtn.click();