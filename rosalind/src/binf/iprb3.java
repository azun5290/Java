package binf;

import java.util.Scanner;

public class iprb3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// #define N 3
		 
/*		// public float compute_probality(int k, int m, int n);
		//void generate_first_event_prob(int para[N], float prob_first[N][N]);
		void generate_second_event_prob(char geno[N][2], float prob_second[N][N]);
		float get_dominant_allele_ratio(char p1[2], char p2[2]);*/
		 
		//int main() {
		  int k,m,n;
		  //FILE *INFILE;
		  //INFILE = fopen("../DATA/rosalind_iprb.txt", "r");
		  //fscanf(INFILE, "%d %d %d", &k, &m, &n);
		  
			Scanner intscn = new Scanner("iprb.txt");
			int arraySize =3;
			int ArrSum =0;
			int mult=0;
			//int k =0,m=0,n=0;
			
			int[] IntArray = new int[arraySize];
			for (int i = 0; i < arraySize; i++){
				IntArray[i] = intscn.nextInt();
				System.out.print(IntArray[i] + " ");

				ArrSum = ArrSum+ IntArray[i];
				mult = ArrSum * (ArrSum -1);
			}
			
			k = IntArray[0];
			m = IntArray[1];
			n = IntArray[2];
		  
		  System.out.println(compute_probality(k,m,n));
		}
		 
		public static float compute_probality(int k, int m, int n) {

			int[] para= {k,m,n};
			float[][] prob_first;
			float[][] prob_second;
			
			/*		  int para[N] = {k,m,n};
		  float prob_first[N][N];
		  float prob_second[N][N];*/
		 
		  /* genotype */
		  /* k AA */
		  /* m Aa */
		  /* n aa */
			
		  //char geno[N][2] = {'A','A', 'A','a', 'a','a'};
		 
			char[] geno = {'A','A', 'A','a', 'a','a'};
		  generate_first_event_prob(para,  prob_first);
		  generate_second_event_prob(geno, prob_second);
		 
		  float prob=(float) 0.0;
		  int i,j;
		  for (i = 0; i < N; ++i) {
		    for (j=0; j < N; ++j) {
		      prob += prob_first[i][j] * prob_second[i][j];
		    }
		  }
		  return prob;
		}
		 
/*		private static void generate_second_event_prob(char[][] geno,float[][] prob_second) {
			// TODO Auto-generated method stub
			
		}

		private static void generate_first_event_prob(int[] para,float[][] prob_first) {
			// TODO Auto-generated method stub
			
		}*/

		private static void generate_first_event_prob(int[] para, float[][] prob_first) {
		  int sum = 0;
		  int i,j;
		  for (i = 0; i < N; ++i) 
		    sum += para[i];
		 
		  for (i = 0; i < N; ++i) 
		    for (j = 0; j < N; ++j) 
		      if (i == j) {
			prob_first[i][j] = (float) para[i]/sum * (para[i]-1)/(sum-1);
		      } else {
			prob_first[i][j] = (float) para[i]/sum * para[j]/(sum-1);
		      }
		}
		 
		private static void generate_second_event_prob(char[] geno, float[][] prob_second) {
		  int i,j;
		  for (i=0; i < N; ++i) 
		    for (j=i; j < N; ++j) {
		      prob_second[i][j] = get_dominant_allele_ratio(geno[i], geno[j]);
		      if ( i != j ) 
		       	prob_second[j][i] = prob_second[i][j]; 
		    }
		}
		 
		float get_dominant_allele_ratio(char p1[2], char p2[2]) {
		  // A for dominant allele
		  // a for recessive allele
		  int total_offspring_type = 4;
		  int n = 0; // has dominant allele
		  int i,j;
		  for (i = 0; i < 2; i++) {
		    for (j = 0; j < 2; j++) {
		      if (p1[i] == 'A') {
			n++;
		      } else if (p2[j] == 'A') {
			n++;
		      } else {
			continue; 
		      }
		    }
		  }
		  float ratio = (float) n / total_offspring_type;
		  return ratio;
		}
		

