/*
 * Copyright (c) 2014-2018 Red Hat, Inc. and/or its affiliates.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package org.jberet.schedule._private;

import org.jberet.schedule.JobScheduleConfig;
import org.jberet.schedule.JobScheduler;
import org.jboss.logging.BasicLogger;
import org.jboss.logging.Logger;
import org.jboss.logging.annotations.Cause;
import org.jboss.logging.annotations.LogMessage;
import org.jboss.logging.annotations.Message;
import org.jboss.logging.annotations.MessageLogger;
import org.jboss.logging.annotations.ValidIdRange;

@MessageLogger(projectCode = "JBERET")
@ValidIdRange(min = 72500, max = 72999)
public interface ScheduleExecutorLogger extends BasicLogger {
    ScheduleExecutorLogger LOGGER = Logger.getMessageLogger(
            ScheduleExecutorLogger.class, "org.jberet.schedule-executor");

    @Message(id = 72500, value = "Created JobScheduler: %s, based on resource: %s")
    @LogMessage(level = Logger.Level.INFO)
    void createdJobScheduler(JobScheduler jobScheduler, String resourceName);

    @Message(id = 72501, value = "Failed to look up the ManagedScheduledExecutorService: %s, and will use the default resource.")
    @LogMessage(level = Logger.Level.WARN)
    void failToLookupManagedScheduledExecutorService(String lookupName);

    @Message(id = 72502,
    value = "The following job execution is scheduled to run after execution %s ends: schedule id %s, %s")
    @LogMessage(level = Logger.Level.INFO)
    void scheduledNextExecution(long currentExecutionId, String scheduleId, JobScheduleConfig scheduleConfig);

    @Message(id = 72503,
    value = "Failed to schedule in current job execution %s")
    @LogMessage(level = Logger.Level.WARN)
    void failToSchedule(@Cause Throwable throwable, long currentExecutionId);

}
