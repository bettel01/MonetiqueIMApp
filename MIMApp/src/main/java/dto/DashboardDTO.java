package dto;

import java.util.List;

public class DashboardDTO {

    private List<LancerDTO> lancers;

    public DashboardDTO(List<LancerDTO> lancers) {
        this.lancers = lancers;
    }

    public List<LancerDTO> getLancers() {
        return lancers;
    }

    public void setLancers(List<LancerDTO> lancers) {
        this.lancers = lancers;
    }
}