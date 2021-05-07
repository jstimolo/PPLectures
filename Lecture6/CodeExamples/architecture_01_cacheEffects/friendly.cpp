#include <iostream>
#include <thread>
#include <vector>
#include <algorithm>
#include <cassert>

int main() {
  const int N = 800000000;

  std::vector<int> data(N);
  std::fill(data.begin(), data.end(), 1); 

  // Given an array of N ones,
  // sum up the first 4 array slots,
  // and that N/4 times.
  // This should be cache friendly.

  long result = 0;
  for (int i = 0; i < N/4; ++i)
    for (int j = 0; j < 4; ++j)
      result += data[j];

  assert(result == N);

  std::cout << "-- done --\n";
}
