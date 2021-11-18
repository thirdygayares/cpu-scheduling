import java.util.Scanner;


public class GayaresLab4 {
	
	public static Scanner sc= new Scanner(System.in);
	public static int TypeNumberJob = 0;
	//0 = Jobs  1 = ARRIVAL TIME 2 = BURST TIME
	public static int Jobs[][] = new int[10][3], waitingTime[] = new int[20], patternNumber = 0,  	
	 completionTime = 0, Gannt = 0, statnumber = 0;
	public static int GanntChart[] = new int[20];  
	public static String patternText;	

	public static void main(String[] args) {
		GanntChart[4] = 5;
		GanntChart[1] = 5;	
		
		System.out.print("ENTER NUMBER OF JOBS (MAXIMUM OF 10): ");
		TypeNumberJob = sc.nextInt();	
	
		numberJobs(TypeNumberJob);

				
					output();
					
					
	}

	static void numberJobs(int NumberJob) {
		int processType;		

		System.out.println("ARRIVAL TIME INPUTS: ");
		for(int x=0; x<NumberJob; x++) {
			
		    Jobs[x][0] = x;
		    patternNumber = Jobs[x][0];
		    patternConversion();
			System.out.print("Process " + patternText + ": ");
	        processType = sc.nextInt();
		    Jobs[x][1] = processType;	
		
		}
		
		System.out.println();
		System.out.println("BURST TIME INPUTS: ");
	
		for(int bt=0; bt<NumberJob; bt++) {	
			patternNumber = Jobs[bt][0];
			  patternConversion();
			System.out.print("Process "  + patternText + ": ");
	        processType = sc.nextInt();
		    Jobs[bt][2] = processType;		
		}	
	}	
	
	static void output() {
		
		int tempJobs=0, TempArrivalTime = 0, tempBurstTime=0;
		
				for(int sort=0;	sort<TypeNumberJob-1;	sort++) {		
					for (int sort2=0;	sort2<TypeNumberJob-1; sort2++) {
						if(Jobs[sort2][1] > Jobs[sort2+1][1]) {
							
							tempJobs = Jobs[sort2][0];
							TempArrivalTime = Jobs[sort2][1];
							tempBurstTime = Jobs[sort2][2];
							
							Jobs[sort2][0] = Jobs[sort2+1][0];
							Jobs[sort2][1] = Jobs[sort2+1][1];
		
							Jobs[sort2][2] = Jobs[sort2+1][2];					
							Jobs[sort2+1][0] = tempJobs;
							Jobs[sort2+1][1] = TempArrivalTime;
							Jobs[sort2+1][2] = tempBurstTime;
						}
					}
				}	
		
		
		
		
		//for testing
		System.out.println("\nOUTPUT: ");
		for(int x=0; x<TypeNumberJob; x++) {
			 patternNumber = Jobs[x][0];
			 patternConversion();
			 System.out.print(patternText  + "     " );
			 
			for(int y=1; y<3; y++) {
				System.out.print(Jobs[x][y] + "     ");
			}
			System.out.println();
		}
		
		
		//GantChart
		
		
		if(Jobs[0][1] == 0) {
		
			completionTime += Jobs[0][2];
			GanntChart[0] = Jobs[0][0];
			statnumber = 1;
			ghanchart();
			
		}else if (Jobs[0][1] > 0) {
			
			GanntChart[0] = 11;
			completionTime += Jobs[0][1];
			statnumber = 0;
			ghanchart();
			
		}
		
		
				
		//printing gantcharts
		System.out.println(" GANTT CHART ");
		for(int xss=0; xss<GanntChart.length; xss++) {
			patternNumber = GanntChart[xss];
			 patternConversion();
			System.out.print(patternText + " " );
		}
		
		
		
		System.out.print("\nEnd Time: " + completionTime);
		
		// 0 = A 1 = B 2 = C 3 = D ....
		// 0 = Jobs 1 = Arrival Time 2 = Burst time 
		
								//		for(int zz=0; zz<20; zz++) {
								//			
								//		}		
	 }
	
		static void ghanchart() {
		
			for(int thirdy=statnumber; thirdy<9; thirdy++) {
				
				if(Jobs[thirdy][1] <= completionTime) {
					
					completionTime += Jobs[thirdy][2];
					if (statnumber == 0) {
					GanntChart[thirdy+1] = Jobs[thirdy][0];
					}else if(statnumber == 1) {
						GanntChart[thirdy] = Jobs[thirdy][0];
					}
				}else if (Jobs[thirdy][1] > completionTime) {					
					   
					GanntChart[thirdy] = 11;
					GanntChart[thirdy+1] = Jobs[thirdy][1];
					
					int idle = 0;
						idle = Jobs[thirdy][1] - idle;
					completionTime += idle;
										
				}
				
			}
				
		}
		
		 
		
		static void patternConversion() {
			if(patternNumber == 0) {
				patternText = "A";
			}else if(patternNumber == 1) {
				patternText = "B";
			}else if(patternNumber == 2) {
				patternText = "C";
			}else if(patternNumber == 3) {
				patternText = "D";
			}else if(patternNumber == 4) {
				patternText = "E";
			}else if(patternNumber == 5) {
				patternText = "F";
			}else if(patternNumber == 6) {
				patternText = "G";
			}else if(patternNumber == 7) {
				patternText = "H";
			}else if(patternNumber == 8) {
				patternText = "I";
			}else if(patternNumber == 9) {
				patternText = "J";
			}else if(patternNumber == 11) {//idle
				patternText = "(i)";
			}
	}
	
		
		
	}
