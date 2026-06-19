-- Author: Lashmini A D
-- CTS DN 5.0 - Week1 - PL/SQL - Exercise01 - Control Structures
-- Scenario 2: Promoted to VIP status based on their balance

SET SERVEROUTPUT ON;
BEGIN
    FOR rec IN (
        SELECT CustomerID, Balance
        FROM Customers
        WHERE Balance > 10000
    ) LOOP
        UPDATE Customers
        SET IsVIP = 'TRUE'
        WHERE CustomerID = rec.CustomerID;

        DBMS_OUTPUT.PUT_LINE('Customer ID ' || rec.CustomerID || ' promoted to VIP.');
    END LOOP;
END;