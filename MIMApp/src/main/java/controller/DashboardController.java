package controller;

import dto.DashboardDTO;
import dto.InstanceInterfaceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.DashboardService;

import java.util.List;

@RestController
@RequestMapping("/mimapi")
public class DashboardController {


    private final DashboardService dashboardService;

    @Autowired
    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/get-lancers")
    public DashboardDTO getDashboardData() {

        DashboardDTO dashboardDTO = dashboardService.getDashboardData();
        return dashboardDTO;
    }

    @GetMapping("/instance-interfaces")
    public List<InstanceInterfaceDTO> getAllInstanceInterfaces() {
        return dashboardService.getAllInstanceInterfaces();
    }


    @GetMapping("/instance-interfaces/{instanceTraitementId}")
    public List<InstanceInterfaceDTO> getInstanceInterfacesByInstanceTraitementId(@PathVariable("instanceTraitementId") Integer instanceTraitementId) {
        return dashboardService.getInstanceInterfacesByInstanceTraitementId(instanceTraitementId);
    }

}
