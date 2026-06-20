package sn.isi.bookservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sn.isi.bookservice.dtos.MemberDTO;

@FeignClient(
        name = "member-service"
)
public interface MemberClient {
    @GetMapping("/api/members/{id}")
    ResponseEntity<MemberDTO> getMember(@PathVariable Integer id);

}
