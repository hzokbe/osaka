package com.hzokbe.osaka.teian.producer;

import com.hzokbe.osaka.teian.dto.proposal.ProposalDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@ApplicationScoped
public class ProposalProducer {
    @Inject
    @Channel("proposal")
    private Emitter<ProposalDTO> proposalEmitter;

    public void sendProposal(ProposalDTO dto) {
        proposalEmitter.send(dto);
    }
}
