// 백준 15678번 연세워터파크
#include <iostream>
#include <queue>

using namespace std;

int main()
{   
    priority_queue<pair<long long, int>> pq;
    int N, D;
    int arr[100001];
    long long temp;
    long long ans = -10000000001;
    
    scanf("%d %d", &N, &D);

    for(int i=0;i<N;i++) scanf("%d", &arr[i]);

    for(int i=0;i<N;i++)
    {
        while(!pq.empty()) {
            if(pq.top().second>=i-D) break;
            pq.pop();
        }
        temp = arr[i];
        if(!pq.empty()) temp = max(temp, arr[i]+pq.top().first);
        pq.push(make_pair(temp,i));
        ans = max(ans, temp);
    }

    printf("%lld",ans);
}