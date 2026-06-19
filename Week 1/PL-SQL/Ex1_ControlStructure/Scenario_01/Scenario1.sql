-- Author: Lashmini A D
-- CTS DN 5.0 - Week1 - PL/SQL - Exercise01 - Control Structures
-- Scenario 1: Loan Interest Discount for Senior Customers

SET SERVEROUTPUT ON;
BEGIN
    FOR rec IN (
        SELECT CustomerID, InterestRate, Age
        FROM Customers
        WHERE Age > 60
    ) LOOP
        UPDATE Customers
        SET InterestRate = InterestRate - 1
        WHERE CustomerID = rec.CustomerID;

        DBMS_OUTPUT.PUT_LINE('1% discount applied to Customer ID: ' || rec.CustomerID);
    END LOOP;
END;