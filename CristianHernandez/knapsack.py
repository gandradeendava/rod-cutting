def knapSack(weightKnapSack, weightObjet, valueObject, numberObjets): 
    M = [[0 for x in range(weightKnapSack+1)] for x in range(numberObjets+1)]
    for i in range(numberObjets+1): 
        for w in range(weightKnapSack+1): 
            if i==0 or w==0: 
                M[i][w] = 0
            elif weightObjet[i-1] <= w:
                M[i][w] = max(valueObject[i-1] + M[i-1][w-weightObjet[i-1]],  M[i-1][w]) 
            else: 
                M[i][w] = M[i-1][w] 
                     
    for x in M:
        print(*x, sep=" ")
    return M[numberObjets][weightKnapSack]
    
valueObject = [60, 100, 120] 
weightObjet = [1, 2, 3] 
weightKnapSack = 8
numberObjets = len(valueObject) 
print(knapSack(weightKnapSack, weightObjet, valueObject, numberObjets)) 