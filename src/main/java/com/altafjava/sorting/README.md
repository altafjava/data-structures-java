| Sorting Algorithm | Best Case Time Complexity | Worst Case Time Complexity | Space Complexity | Adaptive | Stable | Useful for Few Passes? |
| ----------------- | ------------------------- | -------------------------- | ---------------- | -------- | ------ | ---------------------- |
| Bubble Sort       | O(n)                      | O(n^2)                     | O(1)             | Yes      | Yes    | Yes                    |
| Insertion Sort    | O(n)                      | O(n^2)                     | O(1)             | Yes      | Yes    | Yes                    |
| Selection Sort    | O(n^2)                    | O(n^2)                     | O(1)             | No       | No     | Yes                    |
| Merge Sort        | O(n log n)                | O(n log n)                 | O(n)             | Yes      | Yes    | No                     |
| QuickSort         | O(n log n)                | O(n^2) (worst)             | O(log n)         | Yes      | No     | No                     |
| HeapSort          | O(n log n)                | O(n log n)                 | O(1)             | No       | No     | No                     |
| Counting Sort     | O(n + k)                  | O(n + k)                   | O(k)             | No       | Yes    | No                     |
| Radix Sort        | O(nk)                     | O(nk)                      | O(n + k)         | No       | Yes    | No                     |

**Adaptive:** Indicates whether the algorithm can take advantage of sorted order in the input data.
**Stable:** Indicates whether the algorithm preserves the relative order of equal elements in the sorted output.
**Useful for Few Passes:** Indicates whether performing a limited number of passes is generally useful for obtaining partial sorting results (e.g. for obtaining the 3rd largest/smallest elements out of 10).