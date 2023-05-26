def solution(sizes):
    rMax = 0
    cMax = 0
    for i in range(len(sizes)):
        if sizes[i][0] < sizes[i][1]:
            sizes[i][0], sizes[i][1] = sizes[i][1], sizes[i][0]
        rMax = max(rMax, sizes[i][0])
        cMax = max(cMax, sizes[i][1])
    return rMax*cMax