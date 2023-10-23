Use Case Title: Run Main Accounting Procedure 

Context: The timer submits a scheduled request to run the main accounting proceedure at the chosen time that must be fulfilled and delivered 

Actors: Timer 

Main Success Scenario: 

1. The system’s timer submits a scheduled request for the main accounting procedure to be ran 
2. The system’s main account procedure runs included requests for the necessary reports 
3. The system processes the needed reports to be fulfilled for the accounting procedure 
	3a. The system completes the included summary report requested 
	3b. The system completes the included EFT report requested 
	3c. The system completes the included member report requested 
	3d. The system completes the included provider report requested 

4. The system saves and delivers the fulfilled reports requested. 
5. The use case is rendered complete and finishes 

Exceptions: N/A 

----------- 

Use Case Title: Request Reports 

Context: A manager submits a request for their necessary reports that must be fulfilled and delivered 

Actors: Manager 

Main Success Scenario: 

A manager signals the request for their needed reports 

The system processes the needed reports to be fulfilled for the manager’s request 
	2a. The system completes the summary report requested 
	2b. The system completes the EFT report requested 

The system saves and delivers the fulfilled reports requested 

The use case is rendered complete and finishes 

Exceptions: N/A 