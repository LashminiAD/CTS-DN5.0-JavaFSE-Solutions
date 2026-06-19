-- Author: Lashmini A D
-- CTS DN 5.0 - Week1 - PL/SQL - Exercise01 - Control Structures
-- Scenario 3: Reminder for loans due within the next 30 days


SET SERVEROUTPUT ON;
DECLARE
    v_customer_name VARCHAR2(100);
BEGIN
    FOR rec IN (
        SELECT LoanID, CustomerID, DueDate
        FROM Loans
        WHERE DueDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        -- Get customer name
        SELECT Name INTO v_customer_name
        FROM Customers
        WHERE CustomerID = rec.CustomerID;

        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Loan ID ' || rec.LoanID ||
            ' for ' || v_customer_name ||
            ' is due on ' || TO_CHAR(rec.DueDate, 'DD-MON-YYYY')
        );
    END LOOP;
END;