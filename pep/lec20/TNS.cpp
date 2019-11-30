#include<iostream>
#include<vector>
using namespace std;
void swap(vector<int> &arr , int pi , int si){
    int temp=arr[pi];
    arr[pi]=arr[si];
    arr[si]=temp;
}
//==== sort 0 1 and 2 =============================================================================
void sort0and1(vector<int> &arr ){
    int p1=0,p2=0;
    while(p1<arr.size()){
        if(arr[p1]==0){
            swap(arr,p1,p2);
            p2++;
        }
        p1++;
    }
}
void sort01and2(vector<int> &arr){
    int itr =0,p0=0,p2=arr.size()-1;
    while(itr<=p2){
        if(arr[itr]==0){
            swap(arr,itr,p0);
            p0++;
        }
        if(arr[itr]==2){
            swap(arr, itr, p2);
            p2--;
            continue;
        }
        itr++;
    }
}
//===================================================================================================
// void sort012(vector<int> &arr){
//     int p0=0,p1=0,p2=arr.size();
    
// }
void pivot(vector<int> &arr, int pivot , int li , int ri){
    int itr  =li,p1=li;
    while(itr<=ri){
        if(arr[itr]<pivot){ // left condition..
            swap(arr,p1,itr);
            p1++;
        }
        itr++;
    }
}

//===========MERGE SORT======================================================================
vector<int> mergesortedarray( vector<int> &left , vector<int> &right){
    int n = left.size()+ right.size();
    vector<int> arr(n,0);
    int i=0,k=0,j=0;
    while(k<n){
        if(i<left.size() || j<right.size()){
            if(i<left.size() && j<right.size()){
                if(left[i]<right[j]){
                    arr[k] = left[i];
                    i++;
                }
                else{
                    arr[k]=right[j];
                    j++;
                }
            
            }
            else if(i<left.size()){
                arr[k]=left[i];
                i++;
            }
            else if(j<right.size()){
                arr[k]=right[j];
                j++;
            }
          

        }  k++;
    }
    return arr;
}
vector<int> mergesort(vector<int> &arr ,int si , int li){
// base case
if(si==li){
    vector<int> base(1,0);
    base[0]=arr[li];
    return base;
}    
int mid = (si+li)/2;
// vector<int> left(mid-si,0);
// vector<int> right(li-mid+1 , 0);
vector<int> left = mergesort(arr,si,mid);
vector<int> right = mergesort(arr,mid+1,li);
vector<int> newarr = mergesortedarray( left , right);

return newarr;
}
//=========================================================================================================
void display(vector<int> &arr){
    for(int i=0;i<arr.size();i++){
        cout<<arr[i]<<" ";
    }
}
int main(){
    vector<int> oldarr={3,4,45,32,40,78,65};
    // vector<int> arr=mergesort(oldarr, 0,oldarr.size());
    vector<int> zeroone={0,1,1,1,1,0,0,1};
    // sort0and1(zeroone);

    vector<int> zeroonetwo={0,2,2,1,1,2,0,0,1,1,1,2,2,0,0,1};
    sort01and2(zeroonetwo);
    display(zeroonetwo);


    return 0;


}