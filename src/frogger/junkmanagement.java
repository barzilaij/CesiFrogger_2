////junk management
//                    
//                    junkRotateValue++;
//                    int c, d;
//                    for (c = 0; c < junk.size(); c++) {
//
//                        d = c + 1;
//                        
//                        junk.get(c).setRotate(junkRotateValue);
//
//                        //reset to right 
//                        if (junk.get(c).getLayoutX() < 10) {
//                            junk.get(c).setLayoutX(sc.getWidth()+0);
//                            //junk.get(c).setLayoutY(junk.get(c).getLayoutY()+50);
//                        }
//                        
//                        if (junk.get(c).getDirection()==Junk.Direction.DOWN){
//                            junk.get(c).setLayoutY(junk.get(c).getLayoutY()+1);    
//                        }else if (junk.get(c).getDirection()==Junk.Direction.UP){
//                            junk.get(c).setLayoutY(junk.get(c).getLayoutY()-1);    
//                        }
//                        junk.get(c).setLayoutX(junk.get(c).getLayoutX()+5);
//                        
//                        //if lower limit: get back to top    
//                        if (junk.get(c).getLayoutY() > junkMaxY) {
//                            System.out.println("junkMaxY "+junkMaxY);
//                            //junk.get(c).setLayoutY(junkMinY);
//                            junk.get(c).setLayoutX(1000);
//                        }
//
//                    }
//
//import frogger.Junk;
//
