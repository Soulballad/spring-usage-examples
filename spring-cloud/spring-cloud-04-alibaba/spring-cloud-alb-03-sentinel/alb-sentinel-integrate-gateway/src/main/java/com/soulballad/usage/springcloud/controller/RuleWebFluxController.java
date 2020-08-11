package com.soulballad.usage.springcloud.controller;

import com.alibaba.csp.sentinel.adapter.gateway.common.api.ApiDefinition;
import com.alibaba.csp.sentinel.adapter.gateway.common.api.GatewayApiDefinitionManager;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayFlowRule;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Set;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : controller
 * @since ：2020/6/28 20:45
 */
@RestController
public class RuleWebFluxController {

    @GetMapping(value = "/api")
    public Mono<Set<ApiDefinition>> apiRules() {
        return Mono.just(GatewayApiDefinitionManager.getApiDefinitions());
    }

    @GetMapping(value = "/gateway")
    public Mono<Set<GatewayFlowRule>> apiGateway() {
        return Mono.just(GatewayRuleManager.getRules());
    }

    @GetMapping(value = "/flow")
    public Mono<List<FlowRule>> apiFlow() {
        return Mono.just(FlowRuleManager.getRules());
    }
}
