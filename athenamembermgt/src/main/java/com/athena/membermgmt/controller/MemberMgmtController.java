package com.athena.membermgmt.controller;

import java.util.List;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.athena.membermgmt.dto.PolicyMemberDto;
import com.athena.membermgmt.entities.PolicyMember;
import com.athena.membermgmt.service.MemberServiceImpl;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/member")
@AllArgsConstructor
@OpenAPIDefinition(info = @Info(title = "MemberManagement Service", description = "We can log/track Member request", version = "1.0.0"), servers = {
		@Server(url = "http://localhost:8083/member",  description = "development environment") })
public class MemberMgmtController {
	@Autowired
	private final MemberServiceImpl memberServiceImpl;

	@Operation(method = "getPolicyMember")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Fetching member details", content = @Content(mediaType = "application/json", schema = @Schema(anyOf = PolicyMember.class))) })

	@GetMapping(value = "/{memberNo}/details", produces = { MediaType.APPLICATION_JSON_VALUE })
	public PolicyMemberDto getPolicyMember(@PathVariable("memberNo") int memberNo) {
		return memberServiceImpl.getMember(memberNo);
	}

	@Operation(method = "getPolicyMembers")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Fetching all policy member details", content = @Content(mediaType = "application/json", schema = @Schema(anyOf = PolicyMember.class))) })

	@GetMapping(value = "/all", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<PolicyMember> getAllPolicyMemberS() {

		return memberServiceImpl.getAllMembers();
	}

	@Operation(method = "newPolicyMember", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = {
			@Content(mediaType = "application/json", schema = @Schema(anyOf = { PolicyMember.class })) }))
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "new service request logged", content = @Content(mediaType = "application/json", schema = @Schema(anyOf = PolicyMember.class))) })

	@PostMapping(value = "/newPolicyMember", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public PolicyMember newPolicyMember(@RequestBody PolicyMember policyMember) {
		return memberServiceImpl.newMember(policyMember);
	}

	@Operation(method = "UpdatePolicyMembers", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = {
			@Content(mediaType = "application/json", schema = @Schema(anyOf = { PolicyMember.class })) }))
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "updating member details", content = @Content(mediaType = "application/json", schema = @Schema(anyOf = PolicyMember.class))) })

	@PutMapping(value = "/updatePolicyMember", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public PolicyMember UpdatePolicyMembers(@RequestBody PolicyMember policyMember) {
		return memberServiceImpl.updateMember(policyMember);
	}

}
