package com.ust.userservice.service;

import com.ust.userservice.VO.Department;
import com.ust.userservice.VO.ResponseTemplateVo;
import com.ust.userservice.entity.User;
import com.ust.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public ResponseTemplateVo getUserWithDepartment(Long userId) {

        ResponseTemplateVo vo = new ResponseTemplateVo();
        User user = userRepository.findByUserId(userId);

        Department department = restTemplate.getForObject(
                "http://DEPARTMENT-SERVICE/department/" + user.getDepartmentId(),
                Department.class
        );

        vo.setUser(user);
        vo.setDepartment(department);

        return vo;

    }
}
