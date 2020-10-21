package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.service.GroupService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {
    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public List<Group> getGroups() {
        return groupService.getGroups();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<Group> group() {
        return groupService.group();
    }

    @PatchMapping("/{id}/{name}")
    public Group updateGroupName(@PathVariable int id, @PathVariable String name) {
        return groupService.updateGroupName(id, name);
    }
}
