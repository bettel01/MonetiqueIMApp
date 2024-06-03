package controller;



import dto.DashboardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.DashboardService;

@RestController
@RequestMapping("/MIMApi/dashboard")
public class DashboardController {

	
    private final DashboardService dashboardService;

    @Autowired
    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping
    public DashboardDTO getDashboardData() {
    	
    	DashboardDTO dashboardDTO = dashboardService.getDashboardData();
      
        return dashboardDTO;
    }
}
