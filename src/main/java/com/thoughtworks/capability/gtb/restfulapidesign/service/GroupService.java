package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.dto.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.GroupRepository;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupService {
    private final GroupRepository groupRepository;
    private final StudentRepository studentRepository;

    public GroupService(GroupRepository groupRepository, StudentRepository studentRepository) {
        this.groupRepository = groupRepository;
        this.studentRepository = studentRepository;
    }

    public List<Group> getGroups() {
        return groupRepository.getGroups();
    }

    public List<Group> group() {
        initGroups();
        List<Student> students = studentRepository.getShuffledStudents();
        int GROUP_COUNT = 6;
        int perGroup = students.size() / GROUP_COUNT;
        int restToAdd = 0;
        int studentsSize = studentRepository.getStudents().size();
        if (perGroup * GROUP_COUNT < studentsSize) {
            restToAdd = studentsSize - perGroup * GROUP_COUNT;
        }

        int total = 0;
        for (int i = 0; i < GROUP_COUNT; i += 1) {
            List<Student> tmp = new ArrayList<>();
            int tmpAdd = restToAdd > 0 ? perGroup + 1 : perGroup;
            for (int j = 0; j < tmpAdd; j += 1) {
                if (total <= studentsSize) {
                    tmp.add(studentRepository.findById(total));
                    total += 1;
                }
            }
            restToAdd -= 1;
            groupRepository.getGroups().get(i).setStudents(tmp);
        }
        return groupRepository.getGroups();
    }

    private void initGroups() {
        List<Group> groups = new ArrayList<Group>() {
            {
                add(new Group(1, groupRepository.getGroupsName().get(0), new ArrayList<>(), null));
                add(new Group(2, groupRepository.getGroupsName().get(1), new ArrayList<>(), null));
                add(new Group(3, groupRepository.getGroupsName().get(2), new ArrayList<>(), null));
                add(new Group(4, groupRepository.getGroupsName().get(3), new ArrayList<>(), null));
                add(new Group(5, groupRepository.getGroupsName().get(4), new ArrayList<>(), null));
                add(new Group(6, groupRepository.getGroupsName().get(5), new ArrayList<>(), null));
            }
        };
        groupRepository.setGroups(groups);
    }

    public Group updateGroupName(int id, String name) {
        return groupRepository.updateGroupNameById(id, name);
    }
}
