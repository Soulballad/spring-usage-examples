package com.soulballad.usage.springcloud.converter;

import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.List;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : converter
 * @since ：2020/6/27 17:32
 */
public class JsonFlowRuleConverter implements Converter<String, List<FlowRule>> {

    @Override
    public List<FlowRule> convert(String source) {
        return JSON.parseObject(source, new TypeReference<List<FlowRule>>() {
        });
    }
}
