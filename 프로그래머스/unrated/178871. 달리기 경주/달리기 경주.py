def solution(players, callings):
    # 등수: 선수 딕셔너리
    idx_dict = {i: player for i, player in enumerate(players)}
    # 선수: 등수 딕셔너리
    p_dict = {player: i for i, player in enumerate(players)}
    
    for i in callings:
        cur_idx = p_dict[i]              # 현재 선수의 등수
        pre_idx = cur_idx - 1            # 앞 선수의 등수
        pre_player = idx_dict[pre_idx]   # 앞 선수

        idx_dict[cur_idx] = pre_player   # 등수: 선수 딕셔너리에서 현재 선수를 앞 선수 등수로
        idx_dict[pre_idx] = i            # 등수: 선수 딕셔너리에서 앞 선수를 현재 선수 등수로
        
        p_dict[i] = pre_idx             # 선수: 등수 딕셔너리에서 현재 선수의 등수를 앞 선수의 등수로
        p_dict[pre_player] = cur_idx    # 선수: 등수 딕셔너리에서 앞 선수의 등수를 현재 선수의 등수로

    return list(idx_dict.values())