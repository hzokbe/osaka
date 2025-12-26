package com.hzokbe.osaka.teian.controller;

import com.hzokbe.osaka.teian.dto.proposal.request.ProposalRequestDTO;
import com.hzokbe.osaka.teian.service.ProposalService;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/proposals")
public class ProposalController {
    @Inject
    private ProposalService service;

    @POST
    public Response createProposal(ProposalRequestDTO dto) {
        return Response.status(Response.Status.CREATED).entity(service.createProposal(dto)).build();
    }
}
