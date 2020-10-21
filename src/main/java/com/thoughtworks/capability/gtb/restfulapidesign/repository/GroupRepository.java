package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Group;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GroupRepository {
    private List<Group> groups = new ArrayList<>();
    private final List<String> groupsName = new ArrayList<String>() {
        {
            add("1 组");
            add("2 组");
            add("3 组");
            add("4 组");
            add("5 组");
            add("6 组");
        }
    };

    public List<Group> getGroups() {
        return groups;
    }

    public List<String> getGroupsName() {
        return groupsName;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public Group updateGroupNameById(int id, String groupName) {
        Group group = groups.get(id - 1);
        group.setName(groupName);
        groups.set(id - 1, group);
        return group;
    }
}
