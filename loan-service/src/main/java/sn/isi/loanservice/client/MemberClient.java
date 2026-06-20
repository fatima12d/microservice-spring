package sn.isi.loanservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sn.isi.loanservice.dtos.MemberDTO;

@FeignClient(
        name = "member-service",
        path = "/api/members"
)
public interface MemberClient {
    @GetMapping("/{id}")
    MemberDTO getById(@PathVariable("id") Integer id);


}
