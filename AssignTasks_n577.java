package leetcode;

import java.util.*;

/**
 * @author panhao
 * @date 2021年05月30日 11:30 上午
 */
public class AssignTasks_n577 {
    static class ServerUse{
        int index;
        int weight;
        int time;
        public ServerUse(int index, int weight, int time) {
            this.index = index;
            this.weight = weight;
            this.time = time;
        }
    }
    public static int[] assignTasks(int[] servers, int[] tasks) {
        int[] ans=new int[tasks.length];
//        记录所有正在空闲的服务器
        PriorityQueue<ServerUse> queue=new PriorityQueue<>(new Comparator<ServerUse>() {
            @Override
            public int compare(ServerUse o1, ServerUse o2) {
                if (o1.weight==o2.weight) return o1.index-o2.index;
                else return o1.weight-o2.weight;
            }
        });
        for (int i=0;i<servers.length;i++){
            queue.add(new ServerUse(i,servers[i],0));
        }
//        记录正在使用的服务器
        PriorityQueue<ServerUse> usetime=new PriorityQueue<>(new Comparator<ServerUse>() {
            @Override
            public int compare(ServerUse o1, ServerUse o2) {
                if (o1.time==o2.time){
                    if (o1.weight==o2.weight) return o1.index-o2.index;
                    else  return o1.weight-o2.weight;
                }else {
                    return o1.time-o2.time;
                }
            }
        });
        for (int t=0;t<tasks.length;t++){
            if (!usetime.isEmpty()){
                while (!usetime.isEmpty()&&usetime.peek().time<=t){
                    ServerUse server=usetime.poll();
                    server.time=0;
                    queue.add(server);
                }
            }
            if (!queue.isEmpty()){
                ServerUse serverUse=queue.poll();
                serverUse.time=t+tasks[t];
                usetime.add(serverUse);
                ans[t]=serverUse.index;
            }else{
                ServerUse serverUse=usetime.poll();
                serverUse.time+=tasks[t];
                usetime.add(serverUse);
                ans[t]=serverUse.index;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] servers={3,3,2};
        int[] tasks={1,2,3,2,1,2};
        for (int i : assignTasks(servers, tasks)) {
            System.out.println(i);
        }
    }
}
