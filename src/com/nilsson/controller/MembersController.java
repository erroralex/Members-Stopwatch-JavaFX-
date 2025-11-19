package com.nilsson.controller;

import com.nilsson.model.Member;
import com.nilsson.repository.MemberRepository;
import com.nilsson.view.MembersView;

public class MembersController {

    public MembersController(MembersView view) {

        // Load existing members from CSV
        view.setMembers(MemberRepository.loadAll());

        // Save button
        view.saveButton.setOnAction(e -> {
            Member member = new Member(view.firstNameField.getText(), view.lastNameField.getText(), view.phoneField.getText(), view.addressField.getText());
            MemberRepository.save(member);
            view.addMember(member);
            view.clearForm();
        });
    }
}