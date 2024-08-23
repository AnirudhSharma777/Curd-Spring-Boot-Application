package com.example.courseapplication.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.example.courseapplication.dto.EmployeeDto;
import com.example.courseapplication.entities.EmployeeEntity;
import com.example.courseapplication.repositories.EmployeeRepository;

@Service
public class EmployeeService {


    final EmployeeRepository employeeRepository;
    final ModelMapper modelMapper;

    
    public EmployeeService(EmployeeRepository employeeRepository,ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }


    public EmployeeDto getEmployeeById(Long id){
        EmployeeEntity employeeEntity =  employeeRepository.getById(id);
        return modelMapper.map(employeeEntity, EmployeeDto.class);
    }

    public EmployeeDto createNewEmployee(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDto,EmployeeEntity.class);
        return modelMapper.map(employeeEntity, EmployeeDto.class);
    }


    public List<EmployeeDto> getAllEmployee() {
        return employeeRepository
                            .findAll()
                            .stream()
                            .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDto.class))
                            .collect(Collectors.toList());
    }


    public boolean deleteEmployee(Long employeeId) {
       boolean isPresent = employeeRepository.existsById(employeeId);
       if(!isPresent) {
        return false;
       }
       employeeRepository.deleteById(employeeId);
       return true;
    }
}
