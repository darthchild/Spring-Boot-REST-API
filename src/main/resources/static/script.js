const API_BASE_URL = "http://localhost:8080";

document
  .getElementById("addEmployeeForm")
  .addEventListener("submit", async (e) => {
    e.preventDefault();
    const id = document.getElementById("id").value;
    const name = document.getElementById("name").value;
    const isActive = document.getElementById("department").value;
    try {
      const response = await axios.post(`${API_BASE_URL}/employees`, {
        id,
        name,
        isActive,
      });

      document.getElementById(
        "results"
      ).innerHTML = `Employee added: ${JSON.stringify(response.data)}`;
    } catch (error) {
      document.getElementById("results").innerHTML = `Error: ${error.message}`;
    }
  });

document
  .getElementById("getEmployeeForm")
  .addEventListener("submit", async (e) => {
    e.preventDefault();
    const id = document.getElementById("employeeId").value;
    try {
      const response = await axios.get(`${API_BASE_URL}/employees/${id}`);
      document.getElementById(
        "results"
      ).innerHTML = `Employee: ${JSON.stringify(response.data)}`;
    } catch (error) {
      document.getElementById("results").innerHTML = `Error: ${error.message}`;
    }
  });

document
  .getElementById("getAllEmployees")
  .addEventListener("click", async () => {
    try {
      const response = await axios.get(`${API_BASE_URL}/employees/all`);
      document.getElementById(
        "results"
      ).innerHTML = `All Employees: ${JSON.stringify(response.data)}`;
    } catch (error) {
      document.getElementById("results").innerHTML = `Error: ${error.message}`;
    }
  });
