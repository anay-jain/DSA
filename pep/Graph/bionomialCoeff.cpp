#include <iostream>
using namespace std;
  int binomialCoeff(int n, int k)  
    { 
      
        // Base Cases 
        if (k == 0 || k == n) 
            return 1; 
          
        // Recur 
        return binomialCoeff(n - 1, k - 1) +  
                    binomialCoeff(n - 1, k); 
    } 
    void que( char* arr){
        int n = arr.length;
        int ans =0;
        for(int i=0;i<n;i++){
            int count =0;
            for(int j=0;j<n;j++){
                if(arr[i][j]!='.'){
                    count++;
                }

            }
            if(count>=3){
                ans+=binomialCoeff(count,3);
            }

        }
        for(int i=0;i<n;i++){
            int count =0;
            for(int j=0;j<n;j++){
                if(arr[j][i]!='.'){
                    count++;
                }
            }
            if(count>=3){
                ans+=binomialCoeff(count,3);
            }

        }
        int count =0;
        for(int i=0, j=0;i<n;i++,j++){
            if(arr[j][i]!='.'){
                count++;
            }
        }
        if(count>=3){
            ans+=binomialCoeff(count,3);
        }
        count =0;
        for(int i=n-1, j=n-1;i>=0;i--,j--){
            if(arr[j][i]!='.'){
                count++;
            }
        }
        if(count>=3){
            ans+=binomialCoeff(count,3);
        }
        // System.out.println(ans);
        cout<<ans;

    }
int main() {
    int t;
    cin>>t;
    while(t--){
        int n;
        cin>>n;
        char arr = new char[n][n] ;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                cin>>arr[i][j];
            }
        }
        que(arr);
    }
	//code
	return 0;
}