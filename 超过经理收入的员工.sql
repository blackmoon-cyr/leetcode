//Employee 表包含所有员工，他们的经理也属于员工。每个员工都有一个 Id，此外还有一列对应员工的经理的 Id。
//
// +----+-------+--------+-----------+
//| Id | Name  | Salary | ManagerId |
//+----+-------+--------+-----------+
//| 1  | Joe   | 70000  | 3         |
//| 2  | Henry | 80000  | 4         |
//| 3  | Sam   | 60000  | NULL      |
//| 4  | Max   | 90000  | NULL      |
//+----+-------+--------+-----------+
//
//
// 给定 Employee 表，编写一个 SQL 查询，该查询可以获取收入超过他们经理的员工的姓名。在上面的表格中，Joe 是唯一一个收入超过他的经理的员工。
//
//
// +----------+
//| Employee |
//+----------+
//| Joe      |
//+----------+
//
// 👍 335 👎 0


//There is no code of Java type for this problem
/*
    attention: left join ... on ... 这个是用来连接表而生成一个新表的
               ... where ... 查询条件
               不可以  on a.ManagerId = b.Id and a.Salary > b.Salary
               a.Name & Employee a & Employee b 是用来区分a、b表的
               as 查询输出表头部名称
*/
select a.Name as Employee from Employee a left join Employee b on a.ManagerId = b.Id where a.Salary > b.Salary
