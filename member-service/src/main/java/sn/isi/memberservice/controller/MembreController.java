package sn.isi.memberservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.isi.memberservice.dtos.MemberDTO;
import sn.isi.memberservice.service.IMembre;

import java.util.List;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MembreController {

    private final IMembre membreService;

    @PostMapping
    public ResponseEntity<MemberDTO> createMember(@Valid @RequestBody MemberDTO memberDTO) {
        return new ResponseEntity<>(membreService.saveMember(memberDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberDTO> getMemberById(@PathVariable Integer id) {
        return ResponseEntity.ok(membreService.getMemberById(id));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<MemberDTO> getMemberByEmail(@PathVariable String email) {
        return ResponseEntity.ok(membreService.getMemberByEmail(email));
    }

    @GetMapping
    public ResponseEntity<List<MemberDTO>> getAllMembers() {
        return ResponseEntity.ok(membreService.getAllMembers());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberDTO> updateMember(@PathVariable Integer id, @Valid @RequestBody MemberDTO memberDTO) {
        return ResponseEntity.ok(membreService.updateMember(id, memberDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Integer id) {
        membreService.deleteMember(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/activate")
    public ResponseEntity<Void> activateMember(@PathVariable Integer id) {
        membreService.activateMember(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivateMember(@PathVariable Integer id) {
        membreService.deactivateMember(id);
        return ResponseEntity.ok().build();
    }
}
