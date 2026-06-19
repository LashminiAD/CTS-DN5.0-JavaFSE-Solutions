-- Author: Lashmini A D
-- CTS DN 5.0 - Week1 - PL/SQL - Exercise03 - Scenario 2
-- UpdateEmployeeBonus - Add bonus percentage to department employees

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department IN VARCHAR2,
    p_bonus_percent IN NUMBER
)
IS
BEGIN
    FOR rec IN (
        SELECT EmployeeID, Salary
        FROM Employees
        WHERE Department = p_department
    ) LOOP
        UPDATE Employees
        SET Salary = Salary + (Salary * p_bonus_percent / 100)
        WHERE EmployeeID = rec.EmployeeID;

        DBMS_OUTPUT.PUT_LINE('Bonus applied to Employee ID: ' || rec.EmployeeID);
    END LOOP;
END;
/