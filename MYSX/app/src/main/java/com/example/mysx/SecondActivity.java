package com.example.mysx;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle bundle = getIntent().getExtras();
//        Intent intent=getIntent();
        int year = bundle.getInt("ex_tra",5);
        ImageView image = (ImageView) findViewById(R.id.resultImage);
//        int Year=intent.getIntExtra("ex_tra",5);
        show(year);
    }
    private void show(int year){
        int yu=year%12;
        String str= year + "Your Chinese zodiac sign is Monkey";
        if (yu==0) {
            str = year + "Your Chinese zodiac sign is Monkey.The Monkeys are enterprising, competitive, romantic, uninhibite. However, they eat softly but do not eat hard, they often talk out of turn, they are optimistic and pessimistic, they have little security and are somewhat emotional.闻道幽深石涧寺，不逢流水亦难知。莫道山僧无伴侣，猕猴长在古松枝。——朱放《游石涧寺》";
        }
        if (yu==1){
            str = year + "Your Chinese zodiac sign is Rooster.The Roosters are an energetic and articulate person, decisive, perceptive, strong-minded and eager to make a splash. But sometimes he is eccentric, argumentative, stubborn and possessive.";
        }
        if (yu==2){
            str = year + "Your Chinese zodiac sign is Dog.The Dog is strong-willed, faithful, fair, agile and intelligent, used by others, able to listen to and suffer, and realistic. But sometimes impatient, with a tendency to be blind and reckless.日暮苍山远，天寒白屋贫。柴门闻犬吠，风雪夜归人。——刘长卿《逢雪宿芙蓉山主人》";
        }
        if (yu==3){
            str = year + "Your Chinese zodiac sign is Pig.The Pig is sincere, compassionate, honest, enthusiastic, cheerful and optimistic in all things. Their weaknesses are that they are prone to emotions, stubborn and conservative, sometimes short-sighted and unstable.小池聊养鹤，闲田且牧猪。草生元亮径，花暗子云居。倚床看妇织，登垄课儿锄。回头寻仙事，并是一空虚。——王绩《田家三首》";
        }
        if (yu==4){
            str = year + "Your Chinese zodiac sign is Rat.The Rat has a positive attitude, is hard-working, adaptable and good at making friends in all areas. However, they are sometimes suspicious and conservative and do not have enough depth of understanding on individual issues.三更三点万家眠，露欲为霜月堕烟。斗鼠上堂蝙蝠出，玉琴时动倚窗弦。——李商隐《夜半》";
        }
        if (yu==5){
            str = year + "Your Chinese zodiac sign is Ox.The Ox has a sense of justice, loves to fight for justice, is loyal, honest, practical, responsible and has stamina. Their weaknesses are their stubbornness, lack of accommodation and sometimes their tendency to take the bull by the horns and be subjective.银烛秋光冷画屏，轻罗小扇扑流萤。天阶夜色凉如水，卧看牵牛织女星。——杜牧《秋夕》";
        }
        if (yu==6){
            str = year + "Your Chinese zodiac sign is Tiger.The Tiger is a bold, pioneering, enthusiastic and generous person with a sense of justice and a willingness to help others. However, they are sometimes emotional, self-righteous and a little arrogant.龙盘虎踞帝王州，帝子金陵访故丘。春风试暖昭阳殿，明月还过鳷鹊楼。——李白《永王东巡歌十一首·其四》";
        }
        if (yu==7){
            str = year + "Your Chinese zodiac sign is Rabbit.The Rabbit is a gentle, kind, optimistic and delicate person who understands the needs of others and is patient and humble. Their weakness is that they are slightly vain, unstable, easily impatient and often satisfied with the status quo.江水向涔阳，澄澄写月光。镜圆珠溜彻，弦满箭波长。沉钩摇兔影，浮桂动丹芳。延照相思夕，千里共沾裳。——卢照邻《江中望月》";
        }
        if (yu==8){
            str = year + "Your Chinese zodiac sign is Dragon.The Dragon is an enterprising person, decisive, generous, clever and talented, with a high temperament. However, he is easily impatient, a little competitive, subjective and stubborn, and does not give in to defeat.桑条无叶土生烟，箫管迎龙水庙前。朱门几处看歌舞，犹恐春阴咽管弦。——李约《观祈雨》";
        }
        if (yu==9){
            str = year + "Your Chinese zodiac sign is Snake .The Snake is a quick-witted, energetic, easy-going and cheerful person. He is sometimes unpredictable, narrow-minded, sometimes \"bull-headed\", suspicious and not very trusting.欲知垂尽岁，有似赴壑蛇。修鳞半已没，去意谁能遮。况欲系其尾，虽勤知奈何。——苏轼 ";
        }
        if (yu==10){
            str = year + "Your Chinese zodiac sign is Horse.The Horse is always thinking of others, taking everything on his own and believing that he does not need to fight for what is his. He is affectionate and enthusiastic on the outside, but he is easily angry with those he loves the most, and is kind to others.秦时明月汉时关，万里长征人未还。但使龙城飞将在，不教胡马度阴山。——王昌龄《出塞》";
        }
        if (yu==11){
            str = year + "Your Chinese zodiac sign is  Goat .The Goat is easily touched, does not want to be bothered with people, likes to be affirmed and trusted, loves freedom and likes challenges. However, they are somewhat forgetful, paranoid, pessimistic, perfectionist, slightly obsessive-compulsive, eager to be understood but do not ask for it.斜阳照墟落，穷巷牛羊归。野老念牧童，倚杖候荆扉。——王维《渭川田家》";
        }

        TextView textView=(TextView) findViewById(R.id.text1);
        textView.setText(str);
    }
}
