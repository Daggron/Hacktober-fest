#include <iostream>
#include <vector>

using namespace std;

int compute_min_refills(int dist, int tank, vector<int> &stops)
{
    int numFills = 0, currentRefill = 0;
    stops.insert(stops.begin(), 0);
    stops.push_back(dist);
    int n = stops.size() - 2;
    while (currentRefill <= n)
    {
        int lastFill = currentRefill;
        while (currentRefill <= n && stops[currentRefill + 1] - stops[lastFill] <= tank)
        {
            currentRefill++;
        }
        if (currentRefill == lastFill)
        {
            return -1;
        }
        if (currentRefill <= n)
        {
            numFills++;
        }
    }
    return numFills;
}

int main()
{
    int d = 0;
    cin >> d;
    int m = 0;
    cin >> m;
    int n = 0;
    cin >> n;

    vector<int> stops(n);
    for (size_t i = 0; i < n; ++i)
        cin >> stops.at(i);

    cout << compute_min_refills(d, m, stops) << "\n";

    return 0;
}
