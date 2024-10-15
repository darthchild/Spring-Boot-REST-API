package com.darthchild.linear.services;

import com.darthchild.linear.dto.EmployeeDTO;
import com.darthchild.linear.entities.EmployeeEntity;
import com.darthchild.linear.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    final EmployeeRepository employeeRepository;
    final ModelMapper modelMapper;

    // Constructor Injection
    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    // CREATE (POST)
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        return modelMapper.map(
                employeeRepository.save(employeeEntity),
                EmployeeDTO.class);
        // save() func returns a Entity, but we've to return a DTO, so we convert it with Model Mapper
    }

    // READ (GET)
    public EmployeeDTO getEmployeeById(Long id){
        EmployeeEntity employeeEntity = employeeRepository.getById(id);
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }

    // READ ALL
    public List<EmployeeDTO> getAllEmployees() {
//        List<EmployeeDTO> list = new ArrayList<>();
//        for(EmployeeEntity entity : employeeRepository.findAll()){
//            EmployeeDTO dto = modelMapper.map(entity,EmployeeDTO.class);
//            list.add(dto);
//        }
//        return list;
        return employeeRepository
                .findAll()
                .stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    // UPDATE (PUT)
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO){

        boolean isPresent = employeeRepository.existsById(id);

        if(!isPresent){
            return null;
        } else {
            EmployeeEntity employeeEntity  = employeeRepository.getById(id);
            modelMapper.getConfiguration().setSkipNullEnabled(true);
            modelMapper.map(employeeDTO, employeeEntity);

            EmployeeEntity updatedEmployee = employeeRepository.save(employeeEntity);
            return modelMapper.map(updatedEmployee, EmployeeDTO.class);
        }
    }

    // DELETE
    public boolean deleteEmployeeById(Long id) {
        boolean isPresent = employeeRepository.existsById(id);
        if(!isPresent)
            return false;
        employeeRepository.deleteById(id);
        return true;
    }




}

