

#include <iostream>

using namespace std;

int get_1_bits(int n);

int main(){
	int n;
	cin>>n;
	int smaller_n = n-1;
	int larger_n = n+1;
	int one_n_count = get_1_bits(n);
	int smallers_count = get_1_bits(smaller_n);
	int largers_count = get_1_bits(larger_n);

	while (smallers_count != one_n_count) {
		smaller_n--;
		smallers_count = get_1_bits(smaller_n);
	}

	while (largers_count != one_n_count) {
		larger_n++;
		largers_count = get_1_bits(larger_n);
	}
	
	cout << "The number is = " << n <<"\n";
	cout << "Second largest = " << larger_n <<"\n";
	cout << "Second smaller = " << smaller_n;
		
	return 0;
	}
	
int get_1_bits(int n){
	int count = 0;
	while(n != 0){
		if((n&1) == 1){
			count++;
	}else{
		count = count;
		}
		n >>= 1;
	}
	return count;
}
