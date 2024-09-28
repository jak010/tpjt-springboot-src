package com.example.member_service.dto;


import com.example.member_service.entity.MemberEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.query.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@ToString
@Getter
@Setter
@RequiredArgsConstructor
public class MemberPagingRequest {


    @Parameter(name = "nick_name")
    private String nick_name;


    public MemberPagingRequest(
            String nick_name
    ) {
        this.nick_name = nick_name;


    }

}
