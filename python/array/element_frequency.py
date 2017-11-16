def sel_sort(arr, size):
    for i in range(size):
        for j in range(i + 1, size):
            if arr[j] < arr[i]:
                arr[i], arr[j] = arr[j], arr[i]


def quick_sort(arr, start, end):
    if end - start < 2:
        return
    last_low = start - 1
    pivot_el = arr[end - 1]

    for i in range(start, end):
        if arr[i] < pivot_el:
            last_low += 1
            arr[i], arr[last_low] = arr[last_low], arr[i]

    last_low += 1
    arr[last_low], arr[end - 1] = arr[end - 1], arr[last_low]
    quick_sort(arr, start, last_low)
    quick_sort(arr, last_low + 1, end)

def find_element_frequency(arr, size):
    sel_sort(arr, size)
    frequency = 0
    last_element = arr[0]

    for i in range(size):
        if arr[i] == last_element:
            frequency += 1
        else:
            print(last_element, frequency)
            last_element = arr[i]
            frequency = 1
    print(last_element, frequency)


arr = [2, 3, 4, 6, 5, 4, 1, 10, 25, 10, 25, 2, 3, 6, 10]
# find_element_frequency(arr, len(arr))
# print(arr)
arr1 = [2, 40, 3, 5, 9, 6, 8, 7]
quick_sort(arr1, 0, len(arr1))
print(arr1)


