SELECT su.nick_name                                                                                                   as nickName,
       TASK_NAME,
       case TASK_TYPE
           when '0' then 'mantis问题'
           when '1' then '项目问题'
           when '2' then '领导安排工作'
           when '3'
               then '测试申请单' END                                                                                       as TASK_TYPE,
       EXPECT_HOUR,
       op.project_name                                                                                                as projectName,
       op.process_number                                                                                              as processNumber,
       sp.product_name                                                                                                as productName,
       (SELECT SUM(job_hour)
        FROM personal_journal
        WHERE create_by = ?
          AND journal_type = '50'
          AND task_id = ti.task_id)                                                                                   AS real_hour,
       (SELECT SUM(job_hour)
        FROM personal_journal
        WHERE create_by = ?
          AND journal_type = '50'
          AND task_id = ti.task_id
          and curr_date like CONCAT(?, "%"))                                                                          AS moon_real_hour,
       COALESCE(EXPECT_HOUR, 0) - COALESCE((SELECT SUM(job_hour)
                                            FROM personal_journal
                                            WHERE create_by = ? AND journal_type = '50' AND task_id = ti.task_id),
                                           0)                                                                         as totalDifference
FROM task_info ti
         LEFT JOIN oa_project op ON ti.project_id = op.project_id
         LEFT JOIN software_product_info sp ON ti.software_product_id = sp.product_id
         LEFT JOIN sys_user su on su.user_id = ?
WHERE receive_user = ?
LIMIT ?