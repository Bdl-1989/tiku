package io.swagger.controller;

import io.swagger.pojo.dao.Role;
import io.swagger.pojo.dto.BasicResponse;
import io.swagger.pojo.dto.RoleDto;
import io.swagger.service.WebRoleServiceImpl;
import io.swagger.service.WebTagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/role")
public class RoleController extends WebBasicController{
    @Autowired
    private WebRoleServiceImpl webRoleService;

    //列出角色列表，可给添加用户选择
    @RequestMapping("/selectRole")
    public BasicResponse selectRole() {
        BasicResponse basicResponse = new BasicResponse();

        basicResponse.setData(webRoleService.selectRole());

        return basicResponse;
    }

    /**
     * 增加新角色
     *
     * @param roleDto
     * @return
     */
    @PostMapping("/add")
    public BasicResponse add(@RequestBody RoleDto roleDto) {
        BasicResponse basicResponse = new BasicResponse();

        Long createBy = super.getUserId();
        try {
            webRoleService.add(roleDto, createBy);
            basicResponse.setData("角色添加成功");
        } catch (Exception e) {
            basicResponse.setCode(BasicResponse.ERRORCODE);
            basicResponse.setData("角色添加失败: " + e.getMessage());
        }
        return basicResponse;
    }

    /**
     * 删除角色
     *
     * @param idList
     * @return
     */
    @PostMapping("/delete")
    public BasicResponse delete(@RequestBody List<Long> idList) {
        BasicResponse basicResponse = new BasicResponse();
        try {
            webRoleService.deleteAll(idList);
            basicResponse.setData("角色删除成功");
        } catch (Exception e) {
            basicResponse.setData("角色删除失败:" + e.getMessage());
            basicResponse.setCode(BasicResponse.ERRORCODE);
        }
        return basicResponse;
    }





    /**
     * 列出角色列表
     *
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @RequestMapping("/list")
    public BasicResponse list(@RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
        BasicResponse basicResponse = new BasicResponse();

        //判断页码跟页大小参数是否正确
        pageNumber = (pageNumber < 0 ? 0 : pageNumber);
        pageSize = (pageSize < 1 || pageSize > 100 ? 100 : pageSize);
        try {
            Map<String, Object> resultMap = webRoleService.list(pageNumber, pageSize);
            basicResponse.setData(resultMap);
        } catch (Exception e) {
            basicResponse.setCode(BasicResponse.ERRORCODE);
            basicResponse.setData("查询角色列表失败 : " + e.getMessage());
        }
        return basicResponse;
    }

    /**
     * 更改角色信息
     *
     * @param roleDto
     * @return
     */
    @PutMapping("/update")
    public BasicResponse update(@RequestBody RoleDto roleDto) {
        BasicResponse basicResponse = new BasicResponse();

        Long updateBy = super.getUserId();
        try {
            webRoleService.update(roleDto, updateBy);
            basicResponse.setData("更改角色成功");
        } catch (Exception e) {
            basicResponse.setCode(BasicResponse.ERRORCODE);
            basicResponse.setData("更改角色失败: " + e.getMessage());
        }
        return basicResponse;

    }
}
