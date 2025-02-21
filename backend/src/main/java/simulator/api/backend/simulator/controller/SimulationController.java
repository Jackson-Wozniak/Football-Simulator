package simulator.api.backend.simulator.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import simulator.api.backend.simulator.helper.PlaySimulator;

@RestController
@RequestMapping("api/v1/simulation")
@AllArgsConstructor
public class SimulationController {

    private final PlaySimulator playSimulator;

    @GetMapping
    public void simulatePlay(){
        //test method to simulate custom plays with custom inputs
    }
}
