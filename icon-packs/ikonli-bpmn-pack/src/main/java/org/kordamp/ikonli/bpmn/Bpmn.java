/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2015-2023 Andres Almiray
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kordamp.ikonli.bpmn;

import org.kordamp.ikonli.Ikon;

/**
 * @author Andres Almiray
 */
public enum Bpmn implements Ikon {
    AD_HOC_MARKER("bpmn-ad-hoc-marker", '\ue855'),
    BPMN_IO("bpmn-bpmn-io", '\ue831'),
    BUSINESS_RULE("bpmn-business-rule", '\ue818'),
    BUSINESS_RULE_TASK("bpmn-business-rule-task", '\ue827'),
    CALL_ACTIVITY("bpmn-call-activity", '\ue82a'),
    COMPENSATION_MARKER("bpmn-compensation-marker", '\ue858'),
    CONDITIONAL_FLOW("bpmn-conditional-flow", '\ue802'),
    CONNECTION("bpmn-connection", '\ue810'),
    CONNECTION_MULTI("bpmn-connection-multi", '\ue860'),
    DATA_INPUT("bpmn-data-input", '\ue866'),
    DATA_OBJECT("bpmn-data-object", '\ue84b'),
    DATA_OUTPUT("bpmn-data-output", '\ue867'),
    DATA_STORE("bpmn-data-store", '\ue84e'),
    DEFAULT_FLOW("bpmn-default-flow", '\ue803'),
    END_EVENT_CANCEL("bpmn-end-event-cancel", '\ue811'),
    END_EVENT_COMPENSATION("bpmn-end-event-compensation", '\ue81e'),
    END_EVENT_ERROR("bpmn-end-event-error", '\ue822'),
    END_EVENT_ESCALATION("bpmn-end-event-escalation", '\ue82f'),
    END_EVENT_LINK("bpmn-end-event-link", '\ue83b'),
    END_EVENT_MESSAGE("bpmn-end-event-message", '\ue83a'),
    END_EVENT_MULTIPLE("bpmn-end-event-multiple", '\ue839'),
    END_EVENT_NONE("bpmn-end-event-none", '\ue838'),
    END_EVENT_SIGNAL("bpmn-end-event-signal", '\ue837'),
    END_EVENT_TERMINATE("bpmn-end-event-terminate", '\ue836'),
    EVENT_SUBPROCESS_EXPANDED("bpmn-event-subprocess-expanded", '\ue85d'),
    GATEWAY_COMPLEX("bpmn-gateway-complex", '\ue832'),
    GATEWAY_EVENTBASED("bpmn-gateway-eventbased", '\ue833'),
    GATEWAY_NONE("bpmn-gateway-none", '\ue834'),
    GATEWAY_OR("bpmn-gateway-or", '\ue835'),
    GATEWAY_PARALLEL("bpmn-gateway-parallel", '\ue804'),
    GATEWAY_XOR("bpmn-gateway-xor", '\ue80f'),
    GROUP("bpmn-group", '\ue869'),
    HAND_TOOL("bpmn-hand-tool", '\ue868'),
    INTERMEDIATE_EVENT_CATCH_CANCEL("bpmn-intermediate-event-catch-cancel", '\ue805'),
    INTERMEDIATE_EVENT_CATCH_COMPENSATION("bpmn-intermediate-event-catch-compensation", '\ue80e'),
    INTERMEDIATE_EVENT_CATCH_CONDITION("bpmn-intermediate-event-catch-condition", '\ue812'),
    INTERMEDIATE_EVENT_CATCH_ERROR("bpmn-intermediate-event-catch-error", '\ue81d'),
    INTERMEDIATE_EVENT_CATCH_ESCALATION("bpmn-intermediate-event-catch-escalation", '\ue823'),
    INTERMEDIATE_EVENT_CATCH_LINK("bpmn-intermediate-event-catch-link", '\ue82e'),
    INTERMEDIATE_EVENT_CATCH_MESSAGE("bpmn-intermediate-event-catch-message", '\ue83c'),
    INTERMEDIATE_EVENT_CATCH_MULTIPLE("bpmn-intermediate-event-catch-multiple", '\ue847'),
    INTERMEDIATE_EVENT_CATCH_NON_INTERRUPTING_CONDITION("bpmn-intermediate-event-catch-non-interrupting-condition", '\ue85b'),
    INTERMEDIATE_EVENT_CATCH_NON_INTERRUPTING_ESCALATION("bpmn-intermediate-event-catch-non-interrupting-escalation", '\ue848'),
    INTERMEDIATE_EVENT_CATCH_NON_INTERRUPTING_MESSAGE("bpmn-intermediate-event-catch-non-interrupting-message", '\ue806'),
    INTERMEDIATE_EVENT_CATCH_NON_INTERRUPTING_MULTIPLE("bpmn-intermediate-event-catch-non-interrupting-multiple", '\ue851'),
    INTERMEDIATE_EVENT_CATCH_NON_INTERRUPTING_PARALLEL_MULTIPLE("bpmn-intermediate-event-catch-non-interrupting-parallel-multiple", '\ue813'),
    INTERMEDIATE_EVENT_CATCH_NON_INTERRUPTING_SIGNAL("bpmn-intermediate-event-catch-non-interrupting-signal", '\ue852'),
    INTERMEDIATE_EVENT_CATCH_NON_INTERRUPTING_TIMER("bpmn-intermediate-event-catch-non-interrupting-timer", '\ue80c'),
    INTERMEDIATE_EVENT_CATCH_PARALLEL_MULTIPLE("bpmn-intermediate-event-catch-parallel-multiple", '\ue80d'),
    INTERMEDIATE_EVENT_CATCH_SIGNAL("bpmn-intermediate-event-catch-signal", '\ue81c'),
    INTERMEDIATE_EVENT_CATCH_TIMER("bpmn-intermediate-event-catch-timer", '\ue824'),
    INTERMEDIATE_EVENT_NONE("bpmn-intermediate-event-none", '\ue82d'),
    INTERMEDIATE_EVENT_THROW_COMPENSATION("bpmn-intermediate-event-throw-compensation", '\ue83d'),
    INTERMEDIATE_EVENT_THROW_ESCALATION("bpmn-intermediate-event-throw-escalation", '\ue846'),
    INTERMEDIATE_EVENT_THROW_LINK("bpmn-intermediate-event-throw-link", '\ue849'),
    INTERMEDIATE_EVENT_THROW_MESSAGE("bpmn-intermediate-event-throw-message", '\ue850'),
    INTERMEDIATE_EVENT_THROW_MULTIPLE("bpmn-intermediate-event-throw-multiple", '\ue853'),
    INTERMEDIATE_EVENT_THROW_SIGNAL("bpmn-intermediate-event-throw-signal", '\ue85a'),
    LANE("bpmn-lane", '\ue861'),
    LANE_DIVIDE_THREE("bpmn-lane-divide-three", '\ue864'),
    LANE_DIVIDE_TWO("bpmn-lane-divide-two", '\ue865'),
    LANE_INSERT_ABOVE("bpmn-lane-insert-above", '\ue863'),
    LANE_INSERT_BELOW("bpmn-lane-insert-below", '\ue85e'),
    LASSO_TOOL("bpmn-lasso-tool", '\ue862'),
    LOOP_MARKER("bpmn-loop-marker", '\ue809'),
    MANUAL("bpmn-manual", '\ue828'),
    MANUAL_TASK("bpmn-manual-task", '\ue840'),
    PARALLEL_MI_MARKER("bpmn-parallel-mi-marker", '\ue80a'),
    PARTICIPANT("bpmn-participant", '\ue85c'),
    RECEIVE("bpmn-receive", '\ue829'),
    RECEIVE_TASK("bpmn-receive-task", '\ue843'),
    SCREW_WRENCH("bpmn-screw-wrench", '\ue800'),
    SCRIPT("bpmn-script", '\ue83f'),
    SCRIPT_TASK("bpmn-script-task", '\ue84c'),
    SEND("bpmn-send", '\ue841'),
    SEND_TASK("bpmn-send-task", '\ue84d'),
    SEQUENTIAL_MI_MARKER("bpmn-sequential-mi-marker", '\ue816'),
    SERVICE("bpmn-service", '\ue842'),
    SERVICE_TASK("bpmn-service-task", '\ue856'),
    SPACE_TOOL("bpmn-space-tool", '\ue85f'),
    START_EVENT_COMPENSATION("bpmn-start-event-compensation", '\ue807'),
    START_EVENT_CONDITION("bpmn-start-event-condition", '\ue814'),
    START_EVENT_ERROR("bpmn-start-event-error", '\ue81b'),
    START_EVENT_ESCALATION("bpmn-start-event-escalation", '\ue825'),
    START_EVENT_MESSAGE("bpmn-start-event-message", '\ue82c'),
    START_EVENT_MULTIPLE("bpmn-start-event-multiple", '\ue83e'),
    START_EVENT_NONE("bpmn-start-event-none", '\ue845'),
    START_EVENT_NON_INTERRUPTING_CONDITION("bpmn-start-event-non-interrupting-condition", '\ue84a'),
    START_EVENT_NON_INTERRUPTING_ESCALATION("bpmn-start-event-non-interrupting-escalation", '\ue84f'),
    START_EVENT_NON_INTERRUPTING_MESSAGE("bpmn-start-event-non-interrupting-message", '\ue854'),
    START_EVENT_NON_INTERRUPTING_MULTIPLE("bpmn-start-event-non-interrupting-multiple", '\ue859'),
    START_EVENT_NON_INTERRUPTING_PARALLEL_MULTIPLE("bpmn-start-event-non-interrupting-parallel-multiple", '\ue808'),
    START_EVENT_NON_INTERRUPTING_SIGNAL("bpmn-start-event-non-interrupting-signal", '\ue80b'),
    START_EVENT_NON_INTERRUPTING_TIMER("bpmn-start-event-non-interrupting-timer", '\ue815'),
    START_EVENT_PARALLEL_MULTIPLE("bpmn-start-event-parallel-multiple", '\ue81a'),
    START_EVENT_SIGNAL("bpmn-start-event-signal", '\ue826'),
    START_EVENT_TIMER("bpmn-start-event-timer", '\ue82b'),
    SUBPROCESS_COLLAPSED("bpmn-subprocess-collapsed", '\ue81f'),
    SUBPROCESS_EXPANDED("bpmn-subprocess-expanded", '\ue820'),
    SUB_PROCESS_MARKER("bpmn-sub-process-marker", '\ue819'),
    TASK("bpmn-task", '\ue821'),
    TASK_NONE("bpmn-task-none", '\ue857'),
    TEXT_ANNOTATION("bpmn-text-annotation", '\ue830'),
    TRANSACTION("bpmn-transaction", '\ue8c4'),
    TRASH("bpmn-trash", '\ue801'),
    USER("bpmn-user", '\ue844'),
    USER_TASK("bpmn-user-task", '\ue817');

    public static Bpmn findByDescription(String description) {
        for (Bpmn font : values()) {
            if (font.getDescription().equals(description)) {
                return font;
            }
        }
        throw new IllegalArgumentException("Icon description '" + description + "' is invalid!");
    }

    private String description;
    private int code;

    Bpmn(String description, int code) {
        this.description = description;
        this.code = code;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getCode() {
        return code;
    }
}