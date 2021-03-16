package com.czaki.saop;

import com.czaki.saop.model.ws.GetResponse;
import com.czaki.saop.model.ws.GetStudent;
import com.czaki.saop.model.ws.Student;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class StudentEndpoint {

    private StudentService studentService;

    public StudentEndpoint(StudentService studentService) {
        this.studentService = studentService;
    }

    @PayloadRoot(namespace = "http://czaki.pl/soap/", localPart = "getStudent")
    @ResponsePayload
    public GetResponse getStudentById(@RequestPayload GetStudent getStudent) {
        Student studentById = studentService.getStudentById(getStudent.getId());
        GetResponse getResponse = new GetResponse();
        getResponse.setStudent(studentById);
        return getResponse;
    }
}
