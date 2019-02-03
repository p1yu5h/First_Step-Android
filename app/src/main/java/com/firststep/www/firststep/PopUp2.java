package com.firststep.www.firststep;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class PopUp2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up2);
        String text="";
        TextView topic,text_desc;
        topic=(TextView)findViewById(R.id.popup2_topic);
        text_desc=(TextView)findViewById(R.id.popup2_desc);
        String topic_string=getIntent().getStringExtra("topic");
        switch(topic_string){
            case "Communication": text="Purpose of communication is to express oneself through a systematic and traditional use of sounds, signs or written symbols. Learning language is a task for children but it opens up a plethora of avenues for children to explore. Language development is assessed on parameters of spoken and written language. The spoken language is further assessed on 4 parameters – phonology (the ability to pronounce words and to understand speech sounds), semantics (understanding word and sentence meaning), syntax (ability to use rules of grammar to make sentences) and pragmatics (ability to engage in effective and appropriate conversation with others. Written language is assessed on the basis of book handling, knowledge of letters and words, sense of story, writing forms and reading of own writing.";
                break;
            case "Gross Motor": text="Also known as fundamental motor skills, this involves large muscular movements (locomotion). These are the abilities required to control the large muscles of the body for running, walking, jumping, sitting, crawling. These develop over a relatively short period and are governed by two principles that also control physical growth. First principle being, Head to toe development which refers to the way the upper parts of the body develop and Second principle, trunk to extremities. Development starts with the head and then moves down to the body.";
                break;
            case "Fine Motor": text="It involves achieving fine motor control using and coordinating the small muscles in the hand and wrist with mastery. During the development process, children can manipulate small objects such as scissor and writing tools. It involves development of pincer grip and the use of three dominant fingers.";
                break;
            case "Cognitive": text="It focuses on the child development in terms of processing information, reasoning, perceptual skill, language learning. It is the child’s ability to think and understand. Jean Piaget built a theory of cognitive development as to how children think and acquire knowledge from birth to adolescence. The theory deals with the nature of knowledge itself and how humans gradually come to acquire, construct, and use it. Per him a child learns best when he comes in contact and interact with nature and environment. Piaget gave four stages of development. The first one is the sensorimotor stage (0-2 years). In this stage, the child builds an understanding of self and how things work through his interactions with the environment. The next stage is preoperational (2-7 years). During this stage, a child develops his language and concepts. The child needs concrete physical situations. Objects are classified in simple ways like one single colour. Piaget considered the next stage concrete operational stage (7-11 years) as the turning point in the child’s cognitive development as it marks the beginning of logical thinking and operational thought. The child can work things out internally in their head. The child forms an understanding of concepts like time, space and quantity in abstract. The next stage is the formal operations (11-18 years). Cognition reaches its final form. By this stage, the person no longer requires concrete objects to make rational judgements. He or she is capable of deductive and hypothetical reasoning. His or her ability for abstract thinking is very like an adult. During this time, people develop the ability to think about abstract concepts, and logically test hypotheses. Cognitive development is assessed based on three parameters. The first one is knowledge - colours, maths, basic concepts, history etc. The second one is memory – attention, memory strategies. The third one is logical thinking – symbolic thinking, classification, problem solving. Knowledge base includes basic concepts, colour concepts, math concepts, scientific concepts and social study. Memory and logical thinking includes logical reasoning, thinking and problem solving and imagination.";
                break;
            case "Sensory": text="it includes the activity based on sense. As there are no new experiences for the child to take from the Sensorial work, the child can concentrate on the refinement of all his senses, from visual to stereo gnostic. The purpose and aim of Sensorial work is for the child to acquire clear, conscious, information and to be able to then make classifications in his environment. Through work with the sensorial materials, the child is given the keys to classifying the things around him, which leads to the child making his own experiences in his environment. Through the classification, the child is also offered the first steps in organizing his intelligence, which then leads to his adapting to his environment.";
                break;
            case "Social": text="It mainly deals with as to how a child expresses himself. It includes the child’s experience, expression and management of emotions. The core features of this domain are the child’s ability to identify and understand his emotions. Social and emotional development is a child’s ability to understand the feelings of others, control his or her own feelings and behaviours, get along with other children, and build relationships with adults. For children to develop the basic skills they need such as cooperation, following directions, demonstrating self-control and paying attention, they must have social-emotional skills. Having positive social and emotional skills is important throughout life and can have an impact on how they function at home, school and in the community. When young children are faced with social, emotional or behavioural challenges it can impact their chances for school success and healthy relationships. A child's positive relationship with trusting and caring adults is the key to successful emotional and social development.";
                break;
            case "Logical Reasoning": text="To observe and analyse phenomena, reactions and feedback and then draw conclusion based on that input. Logical reasoning is the process of using a rational, systemic series of steps based on sound mathematical procedures and given statements to arrive at a conclusion. Logical reasoning is the ability to ‘foresee’ implications beyond decisions. Honing this skill promotes active learning, whereby the child would be encouraged to ask good question that could aid his own learning process and promotes making the correct and right decision.";
                break;
            case "Balance": text="The ability to maintain a controlled body position during task performance whether it is sitting on the table or stepping up onto a kerb. Balance is attained when the centre of gravity is over the base of support. There are two types of balance- static balance and dynamic balance. Static balance is the balance of body either in one place and dynamic balance is balance of body while in motion.";
                break;
            case "Imagination": text="The creative ability to form images, ideas, and sensations in the mind without any immediate input of the senses (such as seeing or hearing). Imagination helps make knowledge applicable in solving problems and is fundamental to integrating experience and the learning process. A basic training for imagination is listening to storytelling. Imagination can also be expressed through stories such as fairy tales or fantasies. Children use such narratives and pretend play to exercise their imaginations. When children develop fantasy, they play at two levels: first they use role playing to act out what they have developed with their imagination and second level they play again with their make-believe situation by acting as if what they have developed is an actual reality.";
                break;
            case "Thinking And Problem Solving": text="Perhaps the most important thing you can teach a child are oh-so-valuable problem solving skills. Problem solving skills can be applied to all different types of situations in life, from the academic to the social, and will help your child achieve a higher-level thinking ability which rivals that of many adults. Problem solving requires two distinct types of mental skill, analytical and creative. Analytical or logical thinking includes skills such as ordering, comparing, evaluating and selecting. It provides a logical framework for problem solving and helps to select the best alternative from those available by narrowing down the range of possibilities (a convergent process). Creative thinking is a divergent process, using the imagination to create a large range of ideas for solutions.";
                break;
            case "Academic": text="Academic skills are, in general tried and true means of organizing ends. Academic skills are taught directly, through methods involving demonstration, recitation, memorization and repeated practice. All the 4 domains are developed through academic skills.";
                break;
            case "Confidence": text="It includes the activity based on sense. As there are no new experiences for the child to take from the Sensorial work, the child can concentrate on the refinement of all his senses, from visual to stereo gnostic. The purpose and aim of Sensorial work is for the child to acquire clear, conscious, information and to be able to then make classifications in his environment. Through work with the sensorial materials, the child is given the keys to classifying the things around him, which leads to the child making his own experiences in his environment. Through the classification, the child is also offered the first steps in organizing his intelligence, which then leads to his adapting to his environment.";
                break;
            case "Curriculum": text="  Each day’s programme also includes periods of free play where children are encouraged to choose their own activities. Free choice activities foster feelings of independence, self-confidence, and self-awareness. It also promotes situations where children develop social skills such as sharing and respecting others.\n" +
                    "\n" +
                    "            As children at this age are developing an enormous range of skills, we endeavour to stimulate their growth on many different levels: socially, intellectually, physically, linguistically, and artistically.\n" +
                    "\n" +
                    "                    We exercise reasoning skills through games and encourage students to pay attention to their surroundings with segments focused on different animals, the seasons, or transitioning from tadpole to frog and caterpillar to butterfly.\n" +
                    "\n" +
                    "                    We introduce cultural themes and learn about different holidays, especially with the help of our diverse First Step families. An emphasis on play also contributes to refining their fine and gross motor skills.\n";
                break;
            case "Gross Motor2": text="";
                break;
        }
        topic.setText(topic_string);
        text_desc.setText(text);
        CardView card=(CardView)findViewById(R.id.popup2_card);
        Random r=new Random();
        String[] color={"#00CCFF","#F3D430","#F36E27","#ED1683","#E912D4"};
        int x=r.nextInt(4);
        card.setCardBackgroundColor(Color.parseColor(color[x]));
        ImageView back_b=(ImageView)findViewById(R.id.t_back_button);
        back_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
