use sqldb;

-- 1번 
select job as '직무' , truncate(avg(sal), -2)
from emp
where sal is not null and deptno = 30
group by job; 


-- 2번
select dept.dname as "부서명", count(deptno) as "직원 수"
from emp
join dept
using(deptno)
group by deptno
having count(deptno) >= 4;

-- 3번
select ifnull(job, 'TOTAL') as '직무명' ,  format(sum(sal), 0) as "급여의 합"
from emp
group by job
with rollup;

-- 4번
select ename as 직원명 , sal as 급여, salgrade.grade as 급여등급
from emp 
join salgrade
on emp.sal between salgrade.losal and salgrade.hisal
order by sal desc
limit 1;

-- 5번
select ename as 직원명, concat(format(sal + ifnull(comm, 0), 0), '원') as 급여
from emp 
where year(hiredate) = 1981
order by sal + ifnull(comm, 0) desc;

-- 6번
select ename as 직원명, date_format(hiredate, '%Y년 %m월 %d일') as 입사년월일,  case year(hiredate)
when '1980' then "A"
when '1981' then "B"
when '1982' then "C"
when '1983' then "D"
else '없다'
end '없다''결과' from emp;

-- 7번
select e.empno as "사원 사번", e.ename as "사원 이름", m.empno as "관리자 사번",  m.ename as "관리자 이름"
from emp e
join emp m
on e.mgr = m.empno;

-- 8번
select emp.empno, emp.ename, emp.deptno
from emp
join dept
using(deptno)
join locations
using(loc_code)
where locations.CITY = 'CHICAGO';

-- 8번
select emp.empno, emp.ename, emp.deptno
from emp
where deptno in 
(select deptno from dept where loc_code = 
(select loc_code from locations where locations.city  = 'CHICAGO' ));

-- 9번
select ename , sal
from emp
where sal > (select max(sal) from emp where deptno = 30);