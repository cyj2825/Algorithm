def solution(wallpaper):
    minX, maxX, minY, maxY = 51, 0, 51, 0
    for i in range(len(wallpaper)):
        for j in range(len(wallpaper[0])):
            if wallpaper[i][j] == '#':
                minX = min(minX, i)
                maxX = max(maxX, i)
                minY = min(minY, j)
                maxY = max(maxY, j) 
    return [minX, minY, maxX+1, maxY+1]