select * from emp join dept on emp.DEPTNO = dept.deptno;

select * from emp join dept using (deptno);

select ename, emp.deptno, dname
from emp
join dept
on emp.deptno = dept.deptno;

select ename, dept.deptno, dname
from emp
join dept
on emp.deptno = dept.deptno;

select ename, deptno, dname
from emp
join dept
using (deptno); 

select ename,dname, city
from emp
join dept
using (deptno)
join locations
using (loc_code);

select ename, dname, city
from emp e
join dept d
on e.deptno = d.deptno
join locations l
on d.loc_code = l.loc_code;

select ename, city
from emp
join dept
using ( deptno)
join locations
using(loc_code);

select ename, sal, grade
from emp e
join salgrade s
on e.sal between s.losal and s.hisal;

select ename, sal, concat(grade, "등급")
from emp e
join salgrade s
on e.sal >= s.losal and e.sal <= s.hisal;