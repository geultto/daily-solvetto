import sys 

t = int(sys.stdin.readline())

direction = {
    "U":[ 0, 1],
    "D":[ 0,-1], 
    "R":[ 1, 0],
    "L":[-1, 0]
}

for _ in range(t):
    n = int(sys.stdin.readline())
    beads_dict = dict()
    collision_time = -1
    time = 0
    
    for i in range(n):
        x,y,w,d = sys.stdin.readline().split()
        x = int(x) * 2
        y = int(y) * 2
        w = int(w)
        beads_dict[(x,y)] = (w,i,d)
    
    while beads_dict : 
        time += 1
        new_beads_dict = dict()

        for bead in beads_dict : 
            x,y = bead
            w,i,d = beads_dict[bead]
            dx, dy = direction[d]
            x = x+dx
            y = y+dy
            if -2000 <= x <= 2000 and -2000 <= y <= 2000 : 
                if (x,y) not in new_beads_dict.keys() : 
                    new_beads_dict[(x,y)]=(w,i,d)
                else : 
                    collision_time = time
                    new_w, new_i, new_d = new_beads_dict[(x,y)]
                    if new_w < w :
                        new_beads_dict[(x,y)] = (w,i,d)
                    elif new_w == w : 
                        if i > new_i : 
                            new_beads_dict[(x,y)] = (w,i,d)
                            
        beads_dict = dict()

        for key, value in new_beads_dict.items(): 
            beads_dict[key] = value
    
    print(collision_time)